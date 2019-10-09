# android-translator-app
Translator app to show implementation of Android localization

## Summary
App is intended to support localization through native string resource declaration as well as with external data source.

Data source can be hosted anywhere, either in app apk or outside of it, in `csv`, `json`, etc format. Here, I am assuming that we can always tranforrm the data source into json format data, so I directly started with a `json` file for simplicity.

App is dynamic to use the localization data. Meaning, it starts by looking up with `key*` into external data source and and if data with key is found, it is inflated on `TextView`. In cases where lookup was not successful, data on `TextView` already gets inflated from native string resource declaration.

`*key` : It is used to uniquely map each `TextView` with it's respective data set. So for every new `TextView`, you only need to define the mapping into `ViewExtensions.kt` file and rest of the binding will be done automatically.
 
## Prerequisites
`language_data.json` file needs to be updated everytime a new `TextView` is added in order to support the localization with external data source. This file can also be easily generated from any other data source downloaded at runtime e.g., `CSV` files can be converted to `json` files using third party libraries like `OpenCSV`.


