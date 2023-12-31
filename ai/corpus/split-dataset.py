# Credit to: https://github.com/YonglinWang-Brandeis/text-formality-classifier
# formality-dataset-dict.pkl is a slightly modified version of their preprocessing/corpus_dict.pkl

from math import floor
import pickle

# Training : Validation : Testing
SPLIT_PERCENT = (70, 15, 15)
assert(sum(SPLIT_PERCENT) == 100)

with open("ai/corpus/formality-dataset-dict.pkl", "rb") as dataset_file:
    dataset_dict = pickle.load(dataset_file)

num_texts = len(dataset_dict["formal"])
start_index = 0
for i, label in enumerate(("training", "validation", "testing")):
    percent = SPLIT_PERCENT[i]
    end_index = start_index + floor(percent / 100 * num_texts)
    if i == 2:
        end_index += 1
    split_dataset_dict = {k: v[start_index:end_index] for k, v in dataset_dict.items()}
    start_index = end_index
    with open(f"ai/corpus/formality-dataset-dict-{label}.pkl", "wb") as split_dataset_file:
        pickle.dump(split_dataset_dict, split_dataset_file)
