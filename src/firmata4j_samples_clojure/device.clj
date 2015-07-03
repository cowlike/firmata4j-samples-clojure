(ns firmata4j-samples-clojure.device
  (:import [org.firmata4j IODevice]
           [org.firmata4j Pin]
           [org.firmata4j IODevice Pin$Mode]
           [org.firmata4j.firmata FirmataDevice]))

(defn- mk-fake-device []
  (let [fakePin (reify Pin
                  (setMode [_ _] nil)
                  (setValue [_ n] (println "pin value = " n))
                  (getValue [_] 1))]
    (reify IODevice
      (start [_] (println "starting..."))
      (stop [_] (println "stopping..."))
      (ensureInitializationIsDone [_] nil)
      (getPin [_ n] fakePin))))

(defn mk-device
  "Create a handle to the named Firmata device and initialize it.
  nil or FAKE will create a fake test device."
  [devname]
  (if (or (nil? devname) (= devname "FAKE"))
    (mk-fake-device)
    (doto (FirmataDevice. devname)
      (.start)
      (.ensureInitializationIsDone))))

(defn write-pin [dev pin val]
  (let [p (.getPin dev pin)]
    (.setMode p Pin$Mode/OUTPUT)
    (.setValue p val)
    val))

(defn read-pin [dev pin]
  (let [p (.getPin dev pin)]
    (.setMode p Pin$Mode/INPUT)
    (.getValue p)))

(defn pin-on [dev pin]
  (write-pin dev pin 1))

(defn pin-off [dev pin]
  (write-pin dev pin 0))