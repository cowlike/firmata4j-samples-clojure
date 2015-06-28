(ns firmata4j-samples-clojure.core
  (:import [org.firmata4j IODevice]
           [org.firmata4j Pin$Mode]
           [org.firmata4j.firmata FirmataDevice])
  (:require [firmata4j-samples-clojure.blink :refer :all]
            [firmata4j-samples-clojure.fakes :refer :all])
  (:gen-class))

(defn mk-device
  "Create a handle to the named Firmata device and initialize it."
  [devname]
  (doto (FirmataDevice. devname)
    (.start)
    (.ensureInitializationIsDone)))
  
(defn -main
  "pass the string name of the program to run"
  [& args]
  (condp = (first args)
    "blink" (blink (mk-device "COM7") 13)
    "blink-fake" (blink fakeDevice 13)
    (println "Hello, World!")))
