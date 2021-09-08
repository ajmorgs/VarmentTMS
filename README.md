# VarmentTMS

## Introduction

VarmentTMS is an enterprise application that allows users to submit helpdesk tickets using microservices by calling endpoints from the user interface in the browser. 
A headless microservice will automatically assign tickets to technicians. Another microservice can be called that will return a list of helpdesk tickets.

## Storyboard

[Storyboard on Invision] (https://projects.invisionapp.com/prototype/mockup2-ckta9nyr300cbpg01li1h2q7j/play/00801a7f)

## Requirements

### Requirement 1: Submit Ticket

**Scenario**

As a client, I want to be able to submit a help desk ticket, so that my issue will be assigned to a technician.

**Examples**

#### 1.1

**Given:** The user has selected client 

**Given:** The date is 09/07/2021

**When:** The user completes the form with the following inputs:

    First Name: John
    Last Name: Smith
    Work Email: johnsmith@company.com
    Ticket Title:  I cannot connect to the VPN

**Then:**  A helpdesk ticket will be saved with an auto-incrementing ID and the following attributes:

    Author: John Smith
    Ticket Title:  I cannot connect to the VPN
    Submission Date: 09/07/2021

#### 1.2

**Given:** The user has selected client 

**Given:** The date is 09/07/2021

**When:** The user completes the form with the following inputs: 

    First Name: John
    Last Name: Smith
    Work Email: johnsmith
    Ticket Title:  I cannot connect to the VPN
    
**Then:** Nothing will be saved and the user will be asked to check their email


### Requirement 2: See tickets

**Scenario**

As a technician, I want to be able to see a list of helpdesk tickets that are assigned to me, so that I can complete my assigned tasks.

**Examples**

#### 2.1

**Given:** The user with the username: “janesmith@company.com” is a technician and has tickets assigned to her

**When:** The user requests a list of helpdesk tickets for user with the username: “janesmith@company.com”

**Then:** All tickets for the user with the username: “janesmith@company.com” are returned

#### 2.2

**Given:** The user with the username: “johnsmith@company.com” is a client

**When:** The user requests a list of helpdesk tickets for user with the username: “johnsmith@company.com”

**Then:** An error is returned informing the user that “johnsmith@company.com” is not a technician

#### 2.3

**Given:** The user with the username: “janesmith@company.com” is a technician and has no tickets assigned to her

**When:** The user requests a list of helpdesk tickets for user with the username: “janesmith@company.com”

**Then:** The user is given a message that “janesmith@company.com” has no tickets assigned to her


## Class Diagram

![ClassDiagram](https://user-images.githubusercontent.com/18401408/132529714-e145069c-2609-40b5-bb7b-fde0dfa46099.png)

### Class Diagram Description

**VarmentTMSApplication** - application startup

**TicketController** - route requests from browser

**Ticket** - class for ticket objects

**TicketService** - implementation of ITicketService interface

**TicketDAO** - implementation of ITicketDAO interface

**TicketRepository** - provides access to data store

**AssignTicketService** - headless service that assigns new tickets to technicians

## JSON Schema

{
  "type" : "object",
  "properties" : {
	  "firstname": {
		"type": "string"
	  },
	  "lastname": {
		"type": "string"
	  },
	  "email": {
		"type": "string"
	  },
	  "status": {
		"type": "string"
	  },
	  "assignee": {
		"type": "string"
	  },
	  "id": {
		"type": "integer"
	  }
  }
}

## Team Members and Roles

UI Specialist: Mark Petro

Business Logic/Persistence: Vakho Akobia

DevOps/Product Owner/Scrum Master/Github Admin: Tony Morgan

## Standup 

We meet Tuesdays at noon, and one other evening during the week.
