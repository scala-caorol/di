trait Transport {
  def send(s: String)
}

trait Service {
  def execute(x: String): String
}

class MessageService(transport: Transport) extends Service {
  override def execute(x: String): String = {
    val ret = "Hello " + x
    transport.send(ret)
    ret
  }
}

class MessageTransport extends Transport {
  override def send(s: String): Unit = println("Sending message: " + s)
}
