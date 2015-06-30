(ns firmata4j-samples-clojure.hourglass
  (:import [org.firmata4j IODevice Pin$Mode]
           [java.util Date]))

(def switch-pin 12)

(def led-pins (concat (range 2 9) (repeat 8)))

(def interval 1000)
  
(defn write-pin [dev pin val]
  (let [p (.getPin dev pin)]
    (.setMode p Pin$Mode/OUTPUT)
    (.setValue p val)
    val))

(defn read-pin [dev pin]
  (let [p (.getPin dev pin)]
    (.setMode p Pin$Mode/INPUT)
    (.getValue p)))

;; use atoms for the individual pins in the fake device
;; then you can set the values of the atoms in the repl and
;; turn on the switch-pin (for example) independently from the loop
(defn hourglass [^IODevice dev]
(let [led-on #(write-pin dev % 1)
      led-off #(read-pin dev % 0)]
  (loop [leds led-pins prev-switch-state 0 prev-time 0]
    (let [cur-time (.getTime (Date.)) 
          switch-state (read-pin dev switch-pin)]
      (if (> (- cur-time prev-time) interval)
        (do (led-on (first leds))          
          (recur (next leds) switch-state cur-time))
        (if (not= switch-state prev-switch-state)
          (do 
            (doseq [led leds] (led-off led))
            (recur led-pins switch-state cur-time))
          (recur leds prev-switch-state prev-time)))))))
