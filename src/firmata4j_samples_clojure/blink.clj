(ns firmata4j-samples-clojure.blink
  (:import [org.firmata4j IODevice]
           [org.firmata4j Pin$Mode]
           [org.firmata4j.firmata FirmataDevice]))

(defn mk-device
  "Create a handle to the named Firmata device and initialize it."
  [devname]
  (doto (FirmataDevice. devname)
    (.start)
    (.ensureInitializationIsDone)))
  
(defn blink
  "Send commands to blink the specified pin on the device"
  ([dev pin] (blink dev pin 500))
  ([dev pin millis]
    (let [p (.getPin (mk-device dev) pin)]
      (.setMode p Pin$Mode/OUTPUT)
      (loop [state true]
        (.setValue p (if state 1 0))
        (Thread/sleep millis)
        (recur (not state))))))
