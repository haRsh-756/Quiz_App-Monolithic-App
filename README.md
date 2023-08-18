
# Quiz App Using Spring boot framework
Quiz app(Monolithic application) that allows users to create quizzes, answer quiz questions, and calculate quiz results.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)


## Features

- Create quizzes with a specified number of questions and category.
- Answer quiz questions and submit responses.
- Calculate and display quiz results.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- RESTful API design
- H2 Database (or your database of choice)
- Front-end technologies (if applicable)
  
## Usage
- Access the application through a web browser or API client.
- Create a quiz by providing the category, number of questions, and title.
- Answer quiz questions and submit your responses.
- Calculate your quiz result to see how many correct answers you got.

## API Endpoints
- GET /question/allQuestions - Get all questions
- GET /question/category/{category} - Get questions by category
- POST /question/add - Add a new question
- DELETE /question/delete - Delete a question
- DELETE /question/delete/{id} - Delete a question by ID
- POST /quiz/create - Create a new quiz
- GET /quiz/get/{id} - Get quiz questions
- POST /quiz/submit/{id} - Submit quiz responses and calculate result

