package pro.sky.exam.services;

import pro.sky.exam.others.Question;

import java.util.List;

public class JavaQuestionTestConstants {
    public static final String FIRST_QUESTION = "Как определить какие зависимости конфликтуют?";
    public static final String SECOND_QUESTION = "Какие есть способы внедрения бинов?";
    public static final String THIRD_QUESTION = "аннотации @Autowired и @Qualifier ";
    public static final String FOURTH_QUESTION = "Spring scope";
    public static final String FIFTH_QUESTION = "В какой момент создается singleton?";

    public static final String FIRST_ANSWER = "Можно воспользоваться воспользоваться командой Maven dependency:tree";

    public static final String SECOND_ANSWER = "Конструктор, (@Autowired) поля или сеттеры";

    public static final String THIRD_ANSWER = "Аннотация @Autowired используется в Spring Framework для инъекции зависимостей. " +
            "Она автоматически связывает бины с соответствующими зависимостями. " +
            "Если есть несколько кандидатов для внедрения зависимости, можно использовать аннотацию @Qualifier, " +
            "чтобы явно указать, какой бин должен быть использован. Например, если у нас есть два бина типа UserService," +
            " а мы хотим внедрить конкретный бин, мы можем использовать @Qualifier('beanName') для указания имени бина." +
            " Другими словами, аннотация @Autowired автоматически связывает бины, " +
            "а @Qualifier используется для явного указания конкретной зависимости, которую мы хотим использовать.";

    public static final String FOURTH_ANSWER = "Scope определяет время жизни и видимость бина. Скоупы определяют, " +
            "как долго существует экземпляр бина и какие компоненты приложения могут обращаться к этому бину." +
            " В Spring Boot есть пять основных скоупов бинов:\n" +
            "- Singleton (создается только один экземпляр бина на весь контейнер)\n" +
            "- Prototype (создает новый экземпляр бина каждый раз, когда он запрашивается компонентом)\n" +
            "- Request (создаётся при каждом HTTP-запросе)\n" +
            "- Session (один экземпляр бина для каждой HTTP-сессии)\n" +
            "- Application\n" +
            "- Websocket";

    public static final String FIFTH_ANSWER = "при инициализации Spring IoC контейнера";

    public static final int AMOUNT = 1;
    public static final Question newQuestionAdd1 = new Question(FIRST_QUESTION, FIRST_ANSWER);
    public static final Question newQuestionAdd2 = new Question(SECOND_QUESTION, SECOND_ANSWER);
    public static final Question newQuestionAdd3 = new Question(THIRD_QUESTION, THIRD_ANSWER);
    public static final Question newQuestionAdd4 = new Question(FOURTH_QUESTION, FOURTH_ANSWER);
    public static final Question newQuestionAdd5 = new Question(FIFTH_QUESTION, FIFTH_ANSWER);

    public static final List<Question> LIST = List.of(newQuestionAdd1, newQuestionAdd5);
}

