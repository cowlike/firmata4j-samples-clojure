(ns firmata4j-samples-clojure.core
  (:require [firmata4j-samples-clojure.blink :as blink]
            [firmata4j-samples-clojure.hourglass :as hg]
            [firmata4j-samples-clojure.device :refer [mk-device]])
  (:gen-class))

(defn -main
  "pass the string name of the program to run"
  [& args]
  (let [cmd (first args) dev (mk-device (second args))]
    (condp = cmd
      "blink-one" (blink/blink-one dev 8)
      "blink-many" (blink/blink-many dev [2 4 6 8])
      "hourglass" (hg/hourglass dev)
      (println "Hello, World! (bad command)"))))
