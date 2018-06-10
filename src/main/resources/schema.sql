

CREATE TABLE public.answer (
    answer_id integer NOT NULL,
    answer text NOT NULL,
    answer_status integer NOT NULL,
    PRIMARY KEY (answer_id)
);

CREATE TABLE public.question (
    question_id integer NOT NULL,
    answer_id integer,
    question text NOT NULL,
    question_status integer NOT NULL,
    PRIMARY KEY (question_id),
    FOREIGN KEY (answer_id) REFERENCES answer(answer_id)
);