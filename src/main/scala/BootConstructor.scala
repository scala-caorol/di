import scaldi.{Injectable, Injector, Module}

object BootConstructor extends App {
  new RunConstructor
}
class RunConstructor {
  val transport = new MessageTransport
  val output: Service = new MessageService(transport)
  println(output.execute("constructor"))
}


object BootScaldi extends App {
  new RunScaldi()(new UserModule)
}
class RunScaldi(implicit inj: Injector) extends Injectable {
  val output: Service = inject[Service]
  println(output.execute("scaldi"))
}

class UserModule extends Module {
  bind [Transport] to new MessageTransport
  bind [Service] to new MessageService(inject[Transport])
  println("in UserModule")
}