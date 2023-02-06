import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ContentTypes, HttpEntity, HttpResponse}
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn

object BlogApp {
  def main(args: Array[String]): Unit = {
    implicit val system: ActorSystem = ActorSystem("blog-app")
    implicit val materializer: ActorMaterializer = ActorMaterializer()
    implicit val executionContext: ExecutionContextExecutor = system.dispatcher

    val route =
      path("") {
        get {
          complete(HttpResponse(entity = HttpEntity(ContentTypes.`text/html(UTF-8)`,
            "<h1>Welcome to the Blog App</h1>" +
              "<p>You can see the list of blog posts <a href='/posts'>here</a>.</p>"
          )))
        }
      } ~
        path("posts") {
          get {
            complete(HttpResponse(entity = HttpEntity(ContentTypes.`text/html(UTF-8)`,
              "<h1>List of Blog Posts</h1>" +
                "<ul>" +
                "<li><a href='/posts/1'>Post 1</a></li>" +
                "<li><a href='/posts/2'>Post 2</a></li>" +
                "<li><a href='/posts/3'>Post 3</a></li>" +
                "</ul>"
            )))
          }
        } ~
        path("posts" / IntNumber) { postId =>
          get {
            val post = s"Blog Post $postId"
            complete(HttpResponse(entity = HttpEntity(ContentTypes.`text/html(UTF-8)`,
              s"<h1>$post</h1>" +
                "<p>This is the content of the blog post.</p>"
            )))
          }
        }

    val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)

    println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
    StdIn.readLine()

    bindingFuture
      .flatMap(_.unbind())
      .onComplete(_ => system.terminate())
  }
}


//object Main extends App {
//  val post = BlogEngine.createPost("My first blog post", "Hello, hello!", "nikip")
//  println(BlogEngine.showPost(post))
//}
