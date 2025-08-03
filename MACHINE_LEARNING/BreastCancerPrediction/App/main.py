import streamlit as st
import joblib
import pandas as pd
import plotly.graph_objects as go
import numpy as np
from sklearn.metrics import accuracy_score

def get_clean_data():
    data = pd.read_csv("c:\\Users\\CapwellTheNerd\\Desktop\DATA_\\MACHINE_LEARNING\\BreastCancerPrediction\\data\\data.csv")
    
    data = data.drop(columns=['Unnamed: 32', 'id'], axis=1)
    data['diagnosis'] = data['diagnosis'].map({'M': 1, 'B':0})

    return data

def add_sidebar():
    st.sidebar.title("Cell Nuclei Measurements")
    data = get_clean_data()

    slider_labels = [
    ("Radius Mean", "radius_mean"),
    ("Texture Mean", "texture_mean"),
    ("Perimeter Mean", "perimeter_mean"),
    ("Area Mean", "area_mean"),
    ("Smoothness Mean", "smoothness_mean"),
    ("Compactness Mean", "compactness_mean"),
    ("Concavity Mean", "concavity_mean"),
    ("Concave Points Mean", "concave points_mean"),
    ("Symmetry Mean", "symmetry_mean"),
    ("Fractal Dimension Mean", "fractal_dimension_mean"),
    ("Radius SE", "radius_se"),
    ("Texture SE", "texture_se"),
    ("Perimeter SE", "perimeter_se"),
    ("Area SE", "area_se"),
    ("Smoothness SE", "smoothness_se"),
    ("Compactness SE", "compactness_se"),
    ("Concavity SE", "concavity_se"),
    ("Concave Points SE", "concave points_se"),
    ("Symmetry SE", "symmetry_se"),
    ("Fractal Dimension SE", "fractal_dimension_se"),
    ("Radius Worst", "radius_worst"),
    ("Texture Worst", "texture_worst"),
    ("Perimeter Worst", "perimeter_worst"),
    ("Area Worst", "area_worst"),
    ("Smoothness Worst", "smoothness_worst"),
    ("Compactness Worst", "compactness_worst"),
    ("Concavity Worst", "concavity_worst"),
    ("Concave Points Worst", "concave points_worst"),
    ("Symmetry Worst", "symmetry_worst"),
    ("Fractal Dimension Worst", "fractal_dimension_worst")
]

    input_dict = {}

    for label, key in slider_labels:
            input_dict[key] = st.sidebar.slider(
            label=label,
            min_value=0.0,
            max_value=float(data[key].max()),
            value=float(data[key].mean())
        )

    return input_dict


def get_scaled_values(input_data):
    data = get_clean_data()

    X = data.drop(['diagnosis'], axis=1)

    scaled_dict = {}

    for key,value in input_data.items():
        max_value = X[key].max()
        min_value = X[key].min()
        scaled_value = (value - min_value) / (max_value - min_value)
        scaled_dict[key] = scaled_value

    return scaled_dict



def get_radar_chart(input_data):
    input_data = get_scaled_values(input_data)

    categories = ['Radius', 'Texture', 'Perimeter', 'Area',
                   'Smoothness', 'Compactness',
                     'Concavity', 'Concave Points',
                   'Symmetry', 'Fractal Dimension']

    fig = go.Figure()

    fig.add_trace(go.Scatterpolar(
          r=[
            input_data['radius_mean'], input_data['texture_mean'],
            input_data['perimeter_mean'], input_data['area_mean'],
            input_data['smoothness_mean'], input_data['compactness_mean'],
            input_data['concavity_mean'], input_data['concave points_mean'],
            input_data['symmetry_mean'], input_data['fractal_dimension_mean']
          ],
          theta=categories,
          fill='toself',
          name='Mean Value'
    ))
    fig.add_trace(go.Scatterpolar(
          r=[
            input_data['radius_se'], input_data['texture_se'],
            input_data['perimeter_se'], input_data['area_se'],
            input_data['smoothness_se'], input_data['compactness_se'],
            input_data['concavity_se'], input_data['concave points_se'],
            input_data['symmetry_se'], input_data['fractal_dimension_se']
          ],
          theta=categories,
          fill='toself',
          name='Standard Error'
    ))

    fig.add_trace(go.Scatterpolar(
        r=[
            input_data['radius_worst'], input_data['texture_worst'],
            input_data['perimeter_worst'], input_data['area_worst'],
            input_data['smoothness_worst'], input_data['compactness_worst'],
            input_data['concavity_worst'], input_data['concave points_worst'],
            input_data['symmetry_worst'], input_data['fractal_dimension_worst']
        ],
        theta=categories,
        fill='toself',
        name='Worst Value'
    ))

    fig.update_layout(
      polar=dict(
        radialaxis=dict(
          visible=True,
          range=[0, 1]
        )),
      showlegend=True
    )

    return fig

def add_predictions(input_data):
    model = joblib.load('c:\\Users\\CapwellTheNerd\\Desktop\\DATA_\\MACHINE_LEARNING\\BreastCancerPrediction\\model\\model.pkl')
    scaler = joblib.load('c:\\Users\\CapwellTheNerd\\Desktop\\DATA_\\MACHINE_LEARNING\\BreastCancerPrediction\\model\\scaler.pkl')

    input_array = np.array(list(input_data.values())).reshape(1, -1)

    input_array_scaled = scaler.transform(input_array)

    prediction = model.predict(input_array_scaled)


    st.subheader("Cell cluster prediction")


    st.write("The model predicts the cell cluster as: ")

    if prediction[0] == 0: 
        st.write("<span class='diagnosis benign'> Benign (B) </span>", unsafe_allow_html=True)
    else:
        st.write("<span class='diagnosis maligant'> Malignant (M) </span>", unsafe_allow_html=True)

    st.write("Probability of being benign is ", model.predict_proba(input_array_scaled)[0][0])
    st.write("Probability of being malignant is ", model.predict_proba(input_array_scaled)[0][1])

    st.write('This app is designed to be used by medical professionals to assist in the diagnosis of breast cancer based on cytology data. It is not intended for use by patients or individuals without medical training, but should not be used as a substitute for professional medical advice, diagnosis, or treatment. Always seek the advice of your physician or other qualified health provider with any questions you may have regarding a medical condition.')



def main():
    st.set_page_config(
        page_title="Breast Cancer Prediction",
        page_icon=":female-doctor:",
        layout="wide",
        initial_sidebar_state="expanded"
    )

    with open("c:\\Users\\CapwellTheNerd\\Desktop\\DATA_\\MACHINE_LEARNING\\BreastCancerPrediction\\assets\\style.css") as f:
        st.markdown(f"<style>{f.read()}</style>", unsafe_allow_html=True)

    input_data = add_sidebar()

    with st.container():
        st.title("Breast Cancer Predictor")
        st.write("Please connect this app to the cytology lab to help predict breast cancer. This app uses a machine learning model to predict the likelihood of breast cancer based on cytology data. The model has been trained on a dataset of breast cancer cases and is designed to assist in early detection and diagnosis.")

    col1,col2 = st.columns([4,1])


    with col1:
        radar_chart = get_radar_chart(input_data)
        st.plotly_chart(radar_chart)

    with col2:
        add_predictions(input_data)


if __name__ == '__main__':
    main()