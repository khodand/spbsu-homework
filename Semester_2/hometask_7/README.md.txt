7.1
�� ��������� ������, ��������� �������� ��������� Java, ������� � ������� ��������� �������� ����� ������, ����������� ������������ � ��� ��������� ����. ����� � ��������� ������ ����������� � �������� ���� � ������� ClassLoader'�.

7.2
����������� ��� (http://neerc.ifmo.ru/wiki/index.php?title=%D0%91%D0%BE%D1%80)
������ ���� ���������� ��������� ������:

boolean add(String element); (���������� true, ���� ����� ������ ��� �� ����, �������� �� O(|element|))
boolean contains(String element); (�������� �� O(|element|))
boolean remove(String element); (���������� true, ���� ������� ������� ��� � ������, �������� �� O(|element|))
int size(); (�������� �� O(1))
int howManyStartWithPrefix(String prefix); (�������� �� O(|prefix|))
����� ��� ������ ������������� ��������� � ��������:

void serialize(OutputStream out) throws IOException;
void deserialize(InputStream in) throws IOException; (�������� ������ ������ ������� �� ������)