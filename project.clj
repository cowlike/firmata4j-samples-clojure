(defproject firmata4j-samples-clojure "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [com.github.kurbatov/firmata4j "2.3.2"]]
  :main ^:skip-aot firmata4j-samples-clojure.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
