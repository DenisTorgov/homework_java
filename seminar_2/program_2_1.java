// Дана строка sql-запроса "select * from students where ".
// Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные для фильтрации приведены ниже в виде json строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации:
// {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

package seminar_2;

public class program_2_1 {
    public static void main(String[] args) {
        String result = "select * from students where ";
        String request = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        String[] params = request.split(",");
        for (int i = 0; i < params.length; i++) {
            String[] parts = params[i].replace("\\}", "")
                                    .replace("\\{", "")
                                    .replace("\"", "")
                                    .split(":");
            
            if (i >= 1) {result +=" and";}
            if (parts[1].equals("null}") ) {
                result = result.substring(0, result.length()-4);
                continue;
            }
            result += parts[0] + "=" + parts[1];
        }
        System.out.println(result);
    }
}
