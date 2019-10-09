package com.assignment.android.translatorapp;

import android.content.Context;
import android.os.Build;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

class Utils {

    static JSONObject languageData = null;


    static boolean isAtLeastVersion(int version) {
        return Build.VERSION.SDK_INT >= version;
    }

    static void extractLanguageData(Context context) {
        try {
            InputStream is = context.getResources().openRawResource(R.raw.language_data);
            Writer writer = new StringWriter();
            char[] buffer = new char[1024];

            try {
                Reader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                is.close();
            }

            String jsonString = writer.toString();
            if (!jsonString.isEmpty()) {
                languageData = new JSONObject(jsonString);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static String getViewText(String key, String mLanguage) {
        try {
            JSONObject lObject = languageData.getJSONObject(mLanguage);
            String value = lObject.getString(key);
            if (!value.isEmpty()) {
                return value;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}