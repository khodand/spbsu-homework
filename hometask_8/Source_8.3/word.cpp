#include "word.h"

WordInfo *create(String text) {
	WordInfo *newWord = new WordInfo;
	newWord->text = text;
	newWord->number = 1;

	return newWord;
}

void deleteWord(WordInfo *word) {
	clear(word->text);
	delete word;
}