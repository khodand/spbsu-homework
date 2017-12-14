#include "word.h"

wordInfo *create(String text) {
	wordInfo *newWord = new wordInfo;
	newWord->text = text;
	newWord->number = 1;

	return newWord;
}

void deleteWord(wordInfo *word) {
	clear(word->text);
//	delete word;
}