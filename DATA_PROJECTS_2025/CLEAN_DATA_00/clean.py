import pandas as pd

#read the excel file
df = pd.read_excel(r"Customer Call List.xlsx")

#remove duplicate data
df = df.drop_duplicates()

#drop the "unuseful" column
df= df.drop(columns= "Not_Useful_Column")

#Clean the last name by removing unnecessary characters
df["Last_Name"] = df["Last_Name"].str.strip("123 . / _")

#clean the phone number column by removing all other characters except a-z,A-Z and 0-9
df["Phone_Number"] = df["Phone_Number"].str.replace('[^a-zA-Z0-9]', '', regex=True)

#convert the phone_number column into a string using Lambda
df["Phone_Number"] = df["Phone_Number"].apply(lambda x: str(x))

#Separate phone numbers using "-"
df["Phone_Number"] = df["Phone_Number"].apply(lambda x: x[0:3] + "-" + x[3:6] + "-" + x[6:10])

#remove all unnecessary stuff to remain with phone numbers only
df["Phone_Number"] = df["Phone_Number"].str.strip("nan-- Na--")

#split the adress column into 3 for ease of reading
df[["Street_Address","State","Zip_Code"]] = df["Address"].str.split(',',n=3,expand=True)

#delete the address column since it was already splitted - for cleaner data
df = df.drop(columns='Address')

df["Paying Customer"] = df["Paying Customer"].str.replace("No", "N")
df["Paying Customer"] = df["Paying Customer"].str.replace("Yes", "Y")

df["Do_Not_Contact"] = df["Do_Not_Contact"].str.replace("No", "N")
df["Do_Not_Contact"] = df["Do_Not_Contact"].str.replace("Yes", "Y")

df = df.replace("N/a", '')


df = df.fillna('')


#remain with customers that we can only contact
    #i)Eliminate the ones with 'do not contact' set as 'Y'
    #ii)Eliminate the ones with no phone number

for x in df.index:
    if df.loc[x, "Do_Not_Contact"] == 'Y':
        df.drop(x, inplace=True)

for x in df.index:
    if df.loc[x, "Phone_Number"] == "":
        df.drop(x, inplace=True)

#another way to remove blanks in the Phone_Number column

#df.dropna(subset=["Phone_Number"], inplace=True)
    

#reset the index    
df = df.reset_index(drop=True)


#save to excel file
df.to_excel("cleaned_customer_call_list__file.xlsx", index=False)

print(df)