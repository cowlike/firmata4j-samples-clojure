(ns firmata4j-samples-clojure.core
  (:require [firmata4j-samples-clojure.blink :refer :all])
  (:require [firmata4j-samples-clojure.fakes :refer :all])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (condp = (first args)
    "blink" (blink (mk-device "COM7") 13)
    "blink-fake" (blink fakeDevice 13)
    (println "Hello, World!")))
