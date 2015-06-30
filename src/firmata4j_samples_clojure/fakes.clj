(ns firmata4j-samples-clojure.fakes
  (:import [org.firmata4j IODevice]
           [org.firmata4j Pin]))

(defn mk-fake-device []
  (let [fakePin (reify Pin
                  (setMode [_ _] nil)
                  (setValue [_ n] (println "pin value = " n))
                  (getValue [_] 1))]
    (reify IODevice
      (start [_] (println "starting..."))
      (stop [_] (println "stopping..."))
      (ensureInitializationIsDone [_] nil)
      (getPin [_ n] fakePin))))
