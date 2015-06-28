(ns firmata4j-samples-clojure.blink
  (:import [org.firmata4j IODevice]
           [org.firmata4j Pin$Mode]
           [org.firmata4j.firmata FirmataDevice]))

(defn blink
  "Send commands to blink the specified pin on the device"
  ([^IODevice dev ^Long pin] (blink dev pin 500))
  ([^IODevice dev ^Long pin ^Long millis]
    (let [p (.getPin dev pin)]
      (.setMode p Pin$Mode/OUTPUT)
      (loop [state true]
        (.setValue p (if state 1 0))
        (Thread/sleep millis)
        (recur (not state))))))
