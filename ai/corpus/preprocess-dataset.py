import pickle
import nltk
from nltk.stem import PorterStemmer
from nltk.tokenize import word_tokenize

nltk.download("punkt")

def stem_text(text, stemmer):
    words = word_tokenize(text)
    stemmed_words = [stemmer.stem(word) for word in words]
    return " ".join(stemmed_words)

porter_stemmer = PorterStemmer()

for label in ("training", "validation", "testing"):
    with open(f"ai/corpus/formality-dataset-dict-{label}.pkl", "rb") as split_dataset_file:
        dataset_dict = pickle.load(split_dataset_file)
    stemmed_dataset_dict = {k: [stem_text(text, porter_stemmer) for text in v] for k, v in dataset_dict.items()}
    with open(f"ai/corpus/formality-dataset-dict-{label}-preprocessed.pkl", "wb") as stemmed_dataset_file:
        pickle.dump(stemmed_dataset_dict, stemmed_dataset_file)
