CREATE  TABLE QUESTION (
    ID SERIAL PRIMARY KEY,
    QUESTION VARCHAR(255) NOT NULL,
    QUIZID INT NOT NULL,
    CONSTRAINT FK_QUIZID
          FOREIGN KEY(QUIZID)
            REFERENCES QUIZ(ID)
);