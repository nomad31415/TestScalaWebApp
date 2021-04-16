package example

import akka.actor.ActorSystem
import akka.http.javadsl.model.ResponseEntity
import akka.stream.{ActorMaterializer, Materializer}
//import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport
//import io.circe.generic.auto._
import net.softler.client.{ClientRequest, ClientResponse}

import scala.concurrent.{ExecutionContext, Future}
import ujson._


/**
 *   * Sample shows how to fetch json information in an very simple fashion
 *     */
object Hello extends App {

    implicit lazy val system: ActorSystem = ActorSystem()
    implicit lazy val materializer: Materializer = ActorMaterializer()
    implicit lazy val executionContext: ExecutionContext = system.dispatcher
    //val request: ClientRequest[RequestState.Idempotent] = ClientRequest("https://github.com/Freshwood/akka-http-rest-client/blob/master/README.md")
    //val response: Future[ClientResponse] = request.get()
   //  response flatMap (_.as[String]) foreach println



   val r = requests.get("https://my-json-server.typicode.com/druska/trueaccord-mock-payments-api/debts")

     println(r.statusCode)
     //println( r.headers("content-type"))

     println(r.text)


    val json = ujson.read(r.text)


    println(json.arr(0).obj.keys)
    println(json.arr(0))

    json.arr.foreach{i=>println(i.obj , i.obj("id")  )}




    //https://my-json-server.typicode.com/druska/trueaccord-mock-payments-api/payment_plans




    
    //m.keys.foreach{i=>println(i+" "+m(i))}





    //val result: Future[ClientResponse] = ClientRequest("https://api.github.com/users/Freshwood").get()

    //val processed: Future[ResponseEntity] = result map(_.process)



    //println("ggggggggggggggggggggggggggggggggggggggggggggg")

    //processed.foreach(println)


    //println(processed )
}

