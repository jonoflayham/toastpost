(ns toast.core)


(defn pretend-send-txt [number message]
  (println "I would send the following message to" number ":")
  (println message))

(defn send-text [number message]
  (publish :topic-arn "arn:aws:sns:us-east-1:676820690883:my-topic"
           :subject "Toast PST"
           :message message
           :message-attributes {"number" number}))

(defn send-toast-txt [number name place]
  (send-txt number
            (str "Hello " name "!  Your toast is ready for you in the " place "...")))
