from sklearn.metrics import roc_curve
from sklearn.metrics import roc_auc_score
from sklearn.metrics import classification_report
from sklearn.metrics import confusion_matrix
import matplotlib.pyplot as plt
plt.style.use('seaborn-v0_8')

from sklearn.linear_model import LogisticRegression
from sklearn.neighbors import KNeighborsClassifier
from sklearn.tree import DecisionTreeClassifier
from sklearn.ensemble import RandomForestClassifier
from sklearn.svm import SVC
from sklearn.naive_bayes import GaussianNB

from sklearn.datasets import make_classification
from sklearn.model_selection import train_test_split


X,y = make_classification(n_samples = 1000, n_features = 20, random_state = 42)

X_train,X_test, y_train, y_test = train_test_split(X, y, test_size = 0.3, random_state = 42)


models = {
    "Logistic Regression": LogisticRegression(),
    "KNN": KNeighborsClassifier(n_neighbors=5),
    "Decision Tree Classifier": DecisionTreeClassifier(),
    "Random Forest Classifier": RandomForestClassifier(n_estimators=100),
    "SVC": SVC(probability=True),
    "Gaussian Naive Bayes": GaussianNB()
}

colors = ['blue', 'red', 'orange', 'purple', 'brown', 'pink']
pred_probas  = {}

for (name,model),color in zip(models.items(), colors):
    model.fit(X_train, y_train)
    pred_probas[name] = model.predict_proba(X_test)
    fpr, tpr, thresh = roc_curve(y_test, pred_probas[name][:,1], pos_label=1)
    roc_auc = roc_auc_score(y_test, pred_probas[name][:,1])
    plt.plot(fpr,tpr, color=color, linestyle='--', label='{} (AUC = {:.2f})'.format(name, roc_auc))


#for every y_test label append a 0
random_probs = []
for i in range(len(y_test)):
    random_probs.append(0)

p_tpr, p_fpr, threshrd = roc_curve(y_test, random_probs, pos_label=1)

#roc_scores


#plot the curves
plt.plot(p_fpr,p_tpr, color='green', linestyle='--')
plt.title('ROC Curve')
plt.xlabel('False Positive Rate')
plt.ylabel('True Positive Rate')
plt.legend()
plt.show()

