(ns firmata4j-samples-clojure.core
  (:import [org.firmata4j.firmata FirmataDevice])
  (:require [firmata4j-samples-clojure.blink :refer :all]
            [firmata4j-samples-clojure.hourglass :refer :all]
            [firmata4j-samples-clojure.fakes :refer :all])
  (:gen-class))

(defn mk-device
  "Create a handle to the named Firmata device and initialize it."
  [devname]
  (if (= devname "FAKE")
    (mk-fake-device)
    (doto (FirmataDevice. devname)
      (.start)
      (.ensureInitializationIsDone))))
  
(defn -main
  "pass the string name of the program to run"
  [& args]
  (condp = (first args)
    "blink" (blink (mk-device "COM7") 13)
    "blink-fake" (blink (mk-device "FAKE") 13 1500)
    "hourglass" (hourglass (mk-device "COM7"))
    "hourglass-fake" (hourglass (mk-device "FAKE"))
    (println "Hello, World!")))
