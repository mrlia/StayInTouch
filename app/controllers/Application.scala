package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {
  
  def list = Action {
    Ok(views.html.index("Listing contacts."))
  }

  def getContactDetails(name: String) = TODO
  
}
