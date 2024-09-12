# AIROW data processor

## Project structure

- core - library for process json files
- heartratemodel -  methodology for pre-processing and modelling of the heart rate measurements within a lap


## Core

Core is prepared to collect data from many sources based on DataProcessor contexts. Each data source has unique context where all data are collected.
To generate output json, library user has to load all 3 types data and run method process.

### Demo run guide

1. Build core fat jar
```
./gradlew :core:shadowJar
```
2. Run
```
java -jar core/build/libs/core-1.0-SNAPSHOT-all.jar ABSOLUTE_PATH_TO_SUMMARY_JSON ABSOLUTE_PATH_TO_SAMPLES_JSON ABSOLUTE_PATH_TO_LAPS_JSON
```

## Heart rate interpolation model

### Model 

- lost function diff between measured median and predicted with threshold 2
