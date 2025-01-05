import pandas as po

df = po.read_excel("movies.xlsx")

#REmove white spaces

#remove duplicate data
df = df.drop_duplicates()

#remove new lines
df = df.replace("\n", '', regex=True)

#clean the years column
df["YEAR"] = df["YEAR"].str.strip("()")

df["YEAR"] = df["YEAR"].str.replace("[^a-zA-Z0-9]","", regex=True)

df["YEAR"] = df["YEAR"].apply(lambda x: str(x))


df["YEAR"] = df["YEAR"].apply(lambda x: x[0:4] + '-' + x[4:8])
df["YEAR"] = df["YEAR"].str.rstrip("-")

df['STARS'] = df["STARS"].str.strip()
df[['DIRECTOR', 'OUR_STARS']] = df['STARS'].str.split("|", n=2,expand=True)
#df["DIRECTOR"] = df["DIRECTOR"].str.strip("Stars: Director:")
#df["DIRECTOR"] = df["DIRECTOR"].str.replace("Director:",'', regex=False).str.strip()

df['DIRECTOR'] = df['DIRECTOR'].str.extract(r'Director:(.*)')
#df["OUR_STARS"] = df["OUR_STARS"].str.replace("Stars:",'', regex=False).str.strip()

df["STARS"] = df["STARS"].str.extract(r'Star(.*)')
df["STARS"] = df["STARS"].str.lstrip("s:")



df["DIRECTOR"] = df["DIRECTOR"].fillna('unknown')
df["STARS"] = df["STARS"].fillna('unknown')




df["Gross"] = df["Gross"].str.strip("$ M")

df["RATING"] = df["RATING"].apply(lambda y: str(y))
df['RATING'] = df["RATING"].fillna('')

df["Gross"] = df["Gross"].fillna(0).apply(lambda x: float(x))

df = df.drop(columns="OUR_STARS")
row_79 = df.iloc[77]


print(df)