package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

import models.Contact

object Application extends Controller {
  
  def list = Action {
    Ok(views.html.index(Contact.allContacts(), contactForm))
  }

  def getContactDetails(name: String) = TODO
  

  val contactForm = Form(
	  "name" -> nonEmptyText
  )

  def newContact = Action { implicit request =>
	  contactForm.bindFromRequest.fold(
	    errors => BadRequest(views.html.index(Contact.allContacts(), errors)),
	    name => {
	      Contact.create(name)
	      Redirect(routes.Application.list)
	    }
	  )
	}
}
