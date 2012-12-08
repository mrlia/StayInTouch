package models

import play.api.db._
import play.api.Play.current
import anorm._
import anorm.SqlParser._

case class Contact(name: String)



object Contact {
  val newContact = {
    get[String] ("name") map {
      case name => Contact(name)
    }
  }

  def allContacts(): List[Contact] = DB.withConnection { implicit c =>
    SQL("select * from contact").as(newContact *)
  }

  def create(name: String) = DB.withConnection { implicit c =>
    SQL("insert into contact(name) values ({newName})").on(
      'newName -> name
    ).executeUpdate()
  }
  

  def delete(name: String) = Nil

}
