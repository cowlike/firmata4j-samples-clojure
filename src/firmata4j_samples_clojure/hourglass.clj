(ns firmata4j-samples-clojure.hourglass
  (:require [firmata4j-samples-clojure.device :refer [pin-on pin-off read-pin]])
  (:import [java.util Date]))

(def switch-pin 12)

(def led-pins (concat (range 2 9) (repeat 8)))

(def interval 1000)
  
(defn hourglass [dev]
  (let [led-on (partial pin-on dev)
        led-off (partial pin-off dev)]
    (loop [leds led-pins prev-switch-state 0 prev-time 0]
      (Thread/sleep 250)
      (let [cur-time (.getTime (Date.)) 
            switch-state (read-pin dev switch-pin)]
        (if (> (- cur-time prev-time) interval)
          (do 
            (led-on (first leds))
            (recur (next leds) prev-switch-state cur-time))
          (if (not= switch-state prev-switch-state)
            (do 
              (doseq [led (take 8 led-pins)] (led-off led))
              (recur led-pins switch-state cur-time))
            (recur leds prev-switch-state prev-time)))))))
