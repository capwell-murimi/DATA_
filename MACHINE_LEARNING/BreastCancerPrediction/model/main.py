import pandas as pd
from sklearn.preprocessing import StandardScaler
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import accuracy_score, classification_report, confusion_matrix
import joblib

def get_clean_data():
    data = pd.read_csv("c:\\Users\\CapwellTheNerd\\Desktop\DATA_\\MACHINE_LEARNING\\BreastCancerPrediction\\data\\data.csv")
    
    data = data.drop(columns=['Unnamed: 32', 'id'], axis=1)
    data['diagnosis'] = data['diagnosis'].map({'M': 1, 'B':0})

    return data


def create_model(data):
    X = data.drop(['diagnosis'], axis=1)
    y = data['diagnosis']

    scaler = StandardScaler()
    X_scaled = scaler.fit_transform(X)

    X_train, X_test, y_train, y_test = train_test_split(X_scaled,y, test_size=0.2, random_state=42)
    
    model = LogisticRegression()
    model.fit(X_train,y_train)


    y_pred = model.predict(X_test)

    print("Accuracy: ", accuracy_score(y_test,y_pred))
    print("Confusion Matrix:\n", confusion_matrix(y_test, y_pred))
    print("Classification Report:\n", classification_report(y_test, y_pred))

    return model, scaler

   



def main():
    data = get_clean_data()

    model,scaler = create_model(data)

    # Save the model and scaler for future use
    joblib.dump(model, 'c:\\Users\\CapwellTheNerd\\Desktop\DATA_\\MACHINE_LEARNING\\BreastCancerPrediction\\model\\model.pkl')
    joblib.dump(scaler, 'c:\\Users\\CapwellTheNerd\\Desktop\DATA_\\MACHINE_LEARNING\\BreastCancerPrediction\\model\\scaler.pkl')

if __name__ == '__main__':
    main()