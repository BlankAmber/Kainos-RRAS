# AI

Credit
---
- `corpus/formality-dataset-dict.pkl` is a slightly modified version of `preprocessing/corpus_dict.pkl` from [YonglinWang-Brandeis](https://github.com/YonglinWang-Brandeis/text-formality-classifier)

How to run
---
1. Run `corpus/split-dataset.py` to generate datasets for training, validation, and testing
2. Run `corpus/preprocess-dataset.py` to preprocess the three datasets
3. Run `corpus/vectorize-dataset.py` to vectorize the three datasets using TF-IDF

Analysing the dataset
---
- Run cells in `corpus/analyse-dataset.ipynb`
