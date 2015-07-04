(ns firmata4j-samples-clojure.blink
  (:require [firmata4j-samples-clojure.device :refer [read-pin write-pin]])
  (:import [org.firmata4j IODevice]
           [org.firmata4j Pin$Mode]))

(defn blink-one
  "Send commands to blink the specified pin on the device"
  ([dev pin] (blink-one dev pin 21 500))
  ([dev pin times millis]
    (loop [state true times times]
      (write-pin dev pin (if state 1 0)) 
      (Thread/sleep millis)
      (if (zero? times)
        (.stop dev)
        (recur (not state) (dec times))))))

(defn blink-many
  "Send commands to blink some pins on the device"
  ([dev pins] (blink-many dev pins 500))
  ([dev pins millis]
    (let [ps (cycle pins)]
      (doseq [p ps] 
        (write-pin dev p 1)
        (Thread/sleep millis)
        (write-pin dev p 0)))))

(defn knight-rider
  "Light up the leds in sequence and turn off in reverse"
  ([dev] (knight-rider dev (range 2 9)))
  ([dev pins]
    (dotimes [_ 10]
      (doseq [p (concat pins (reverse pins))]
        (write-pin dev p 1)
        (Thread/sleep 50)
        (write-pin dev p 0)))))