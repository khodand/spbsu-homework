#include "List.h"

ListElement *create(WordInfo *word) {
	ListElement *newEl = new ListElement;
	newEl->word = word;
	newEl->next = nullptr;

	return newEl;
}

bool isWordIn(String text, List &list) {
	for (int i = 0; i < list.size; ++i) {
		WordInfo curWord = get(i, list);
		if (areEqual(text, curWord.text)) {
			setNumber(i, list, curWord.number + 1);
			return true;
		}
	}
	return false;
}

void add(WordInfo *word, List &list) {
	if (isEmpty(list)) {
		list.first = create(word);
		list.last = list.first;
		list.size++;
	}
	else {
		if (!isWordIn(word->text, list)) {
			list.last->next = create(word);
			list.last = list.last->next;
			list.size++;
		}
		else
			delete(word);
	}
}

WordInfo get(int i, List &list) {
	ListElement *temp = list.first;
	while (i > 0) {
		temp = temp->next;
		--i;
	}

	return *temp->word;
}

void setNumber(int i, List &list, int number) {
	ListElement *temp = list.first;
	while (i > 0) {
		temp = temp->next;
		--i;
	}
	temp->word->number = number;
}

void remove(int i, List &list) {
	if (i == 0) {
		deleteWord(list.first->word);
		list.first = list.first->next;
	}
	else {
		ListElement *temp = list.first;
		while (i > 1) {
			temp = temp->next;
			--i;
		}

		deleteWord(temp->next->word);
		temp->next = temp->next->next;
	}
	list.size--;
}

bool isEmpty(List &list) {
	return list.first == nullptr;
}

void clear(List &list) {
	while (!isEmpty(list))
		remove(0, list);
}

int getFrequencyOfWord(String text, List &list) {
	for (int i = 0; i < list.size; ++i) {
		WordInfo curWord = get(i, list);
		if (areEqual(text, curWord.text))
			return curWord.number;
	}
	return 0;
}

int numberOfWords(List &list) {
	int result = 0;
	for (int i = 0; i < list.size; ++i) {
		result += get(i, list).number;
	}

	return result;
}