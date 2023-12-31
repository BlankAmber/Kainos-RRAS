import pandas as pd
import pickle
from sklearn.feature_extraction.text import TfidfVectorizer

vectorizer = TfidfVectorizer(stop_words="english", max_features=5000)

for label in ("training", "validation", "testing"):
    with open(f"ai/corpus/formality-dataset-dict-{label}-preprocessed.pkl", "rb") as dataset_file:
        dataset_dict = pickle.load(dataset_file)
    dataframe = pd.DataFrame(
        [(label, text)  for label, texts in dataset_dict.items() for text in texts],
        columns=["Formality", "Text"])
    tfidf_matrix = vectorizer.fit_transform(dataframe["Text"]).toarray()
    with open(f"ai/corpus/formality-dataset-dict-{label}-vectorized.pkl", "wb") as vectorized_dataset_file:
        pickle.dump(tfidf_matrix, vectorized_dataset_file)
