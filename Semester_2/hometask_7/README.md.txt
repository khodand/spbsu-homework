7.1
По заданному классу, используя механизм рефлексии Java, вывести в консоль текстовое описание этого класса, максимально приближенное к его исходному коду. Класс в программу должен загружаться в бинарном виде с помощью ClassLoader'а.

7.2
Реализовать бор (http://neerc.ifmo.ru/wiki/index.php?title=%D0%91%D0%BE%D1%80)
Должны быть поддержаны следующие методы:

boolean add(String element); (возвращает true, если такой строки ещё не было, работает за O(|element|))
boolean contains(String element); (работает за O(|element|))
boolean remove(String element); (возвращает true, если элемент реально был в дереве, работает за O(|element|))
int size(); (работает за O(1))
int howManyStartWithPrefix(String prefix); (работает за O(|prefix|))
Также бор должен реализовывать интерфейс с методами:

void serialize(OutputStream out) throws IOException;
void deserialize(InputStream in) throws IOException; (заменяет старое дерево данными из стрима)