 import pandas as po

df = po.read_excel("movies.xlsx")

#REmove white spaces

#remove duplicate data
df = df.drop_duplicates()

#remove new lines
df = df.replace("\n", '', regex=True)

#clean the movies column
df["MOVIES"] = df["MOVIES"].apply(lambda x: str(x))

#clean the years column
df["YEAR"] = df["YEAR"].str.strip("()")

df["YEAR"] = df["YEAR"].str.replace("[^a-zA-Z0-9]","", regex=True)

df["YEAR"] = df["YEAR"].apply(lambda x: str(x))


#df["YEAR"] = df["YEAR"].apply(lambda x: x[0:4] + '-' + x[4:8])
df["YEAR"] = df["YEAR"].str.extract(r'(\d{4})')
df["YEAR"] = df["YEAR"].fillna('0')
df["YEAR"] = df["YEAR"].apply(lambda x: x[:4] if len(x) > 4 else x)
df["YEAR"] = df["YEAR"].apply(lambda x: int(x))

df['STARS'] = df["STARS"].str.strip()
df[['DIRECTOR', 'OUR_STARS']] = df['STARS'].str.split("|", n=2,expand=True)
#df["DIRECTOR"] = df["DIRECTOR"].str.strip("Stars: Director:")
#df["DIRECTOR"] = df["DIRECTOR"].str.replace("Director:",'', regex=False).str.strip()

df['DIRECTOR'] = df['DIRECTOR'].str.extract(r'Director:(.*)')
#df["OUR_STARS"] = df["OUR_STARS"].str.replace("Stars:",'', regex=False).str.strip()

df["STARS"] = df["STARS"].str.extract(r'Star(.*)')
df["STARS"] = df["STARS"].str.lstrip("s:")



df["DIRECTOR"] = df["DIRECTOR"].fillna('Unknown')
df["STARS"] = df["STARS"].fillna('Unknown')

df["RATING"] = df["RATING"].dropna()
df["RATING"] = df["RATING"].apply(lambda y: float(y))
#df["RATING"] = df["RATING"].str.replace("nan", "Unknown")
df["RATING"] = df["RATING"].fillna(0)




df["VOTES"] = df["VOTES"].apply(lambda x: str(x))
df["VOTES"] = df["VOTES"].str.replace("nan", "Unknown")



df["RunTime"] = df["RunTime"].apply(lambda x: str(x))
df["RunTime"] = df["RunTime"].str.replace("nan", "Unknown")




df["Gross"] = df["Gross"].str.strip("$ M")
df["Gross"] = df["Gross"].apply(lambda x: str(x))
df["Gross"] = df["Gross"].str.replace("nan", "Unknown")



df = df.drop(columns="OUR_STARS")


df = df[["MOVIES","YEAR","GENRE","RATING","ONE-LINE","DIRECTOR","STARS","VOTES","RunTime","Gross"]]


df = df.rename(columns= str.upper)




for x in df.index:
    if df.loc[x, "RATING"] == 0:
        df.drop(x, inplace=True)

df = df.reset_index(drop=True)



#row_79 = df.iloc[77]



datatype = df.dtypes["YEAR"]

print(datatype)
df[["MOVIES","YEAR","RATING"]].to_excel("cleanedtoanalyze_movies.xlsx", index=False)



base_year = 2000

older_movies = df[df["YEAR"] <= base_year]
newer_movies = df[df["YEAR"] > base_year]

older_movies[["MOVIES","YEAR","RATING"]].to_excel("older_movies.xlsx", index=False)
newer_movies[["MOVIES","YEAR","RATING"]].to_excel("newer_movies.xlsx", index=False)

old_mean_rating = older_movies["RATING"].mean()
new_mean_rating = newer_movies["RATING"].mean()


print(f"Old movie preference: {old_mean_rating * 10}%")
print(f"New movie preference: {new_mean_rating * 10}%")

if old_mean_rating > new_mean_rating:
    print("People prefer old stuff according to the data set")
elif new_mean_rating > old_mean_rating:
    print("People prefer newer stuff according to the dataset")
else:
    print("Equal preferences")

print(df[["MOVIES","YEAR","RATING"]])