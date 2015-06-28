(ns firmata4j-samples-clojure.core
  (:require [firmata4j-samples-clojure.blink :refer :all])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (condp = (first args)
    "blink" (blink "COM7" 13)
    (println "Hello, World!")))
