(ns toast.core
  (:use [amazonica.aws.sns]))

(defn send-txt [number message]
  (publish :phone-number number
           :message message
           :message-attributes {"AWS.SNS.SMS.SenderID" "ToastPost"
                                "AWS.SNS.SMS.SMSType" "Transactional"}))

(defn countdown [action-description seconds]
  (println action-description)
  (Thread/sleep 3000)
  (doall (map #(do (Thread/sleep 1000) (println (- seconds %) " ")) (range seconds))))

(defn send-toast-txt [number name place]
  '(send-txt number
             (str "Hello " name "!  Your toast is ready for you in the " place "...")))















(defn just-to-cite-otherwise-uncited-function-to-keep-the-ide-looking-pretty [] countdown send-toast-txt)
