(ns firmata4j-samples-clojure.fakes
  (:import [org.firmata4j IODevice]
           [org.firmata4j Pin]
           [org.firmata4j Pin$Mode]
           [org.firmata4j.firmata FirmataDevice]))

(def fakePin
  (reify Pin
    (setMode [_ _] nil)
    (setValue [_ n] (println "pin value = " n))
    (getValue [_] 1)))

(def fakeDevice
  (reify IODevice
    (start [_] (println "starting..."))
    (stop [_] (println "stopping..."))
    (ensureInitializationIsDone [_] nil)
    (getPin [_ n] fakePin)))
