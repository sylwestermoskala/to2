CREATE TABLE questions(
                        id SERIAL,
                        question varchar(1000),
                        answer_a varchar(1000),
                        answer_b varchar(1000),
                        answer_c varchar(1000),
                        answer_d varchar(1000),
                        answer varchar(1000),
                        category varchar(100),
                        primary key(id)
);
INSERT INTO questions(question,answer_a,answer_b,answer_c,answer_d,answer,category) VALUES ('What is Encapsulation?', 'Encapsulation is a technique to define<br>different methods of same type.', 'Encapsulation is the ability of an object<br>to take on many forms.', 'Encapsulation is the technique of making the <br>fields in a class private and <br>providing access to the fields via public methods.', 'None of the above.', 'C', 'Java Object Oriented');
INSERT INTO questions(question,answer_a,answer_b,answer_c,answer_d,answer,category) VALUES ('What is correct syntax for main method of a java class?', 'public static int main(String[] args)', 'public int main(String[] args)', 'public static void main(String[] args)', 'None of the above.', 'C', 'Java Object Oriented');
