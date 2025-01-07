import pandas as po

# Load the Excel file
df = po.read_excel("movies.xlsx")

# Remove duplicate data
df = df.drop_duplicates()

# Remove white spaces and new lines
df = df.replace("\n", '', regex=True)

# Clean the 'YEAR' column
df["YEAR"] = df["YEAR"].str.strip("()")  # Remove parentheses
df["YEAR"] = df["YEAR"].str.replace("[^a-zA-Z0-9]", "", regex=True)  # Remove non-alphanumeric characters
df["YEAR"] = df["YEAR"].apply(lambda x: str(x))  # Convert to string
df["YEAR"] = df["YEAR"].apply(lambda x: x[:4] + '-' + x[4:8] if len(x) > 4 else x)  # Format as 'YYYY-YYYY'
df["YEAR"] = df["YEAR"].str.rstrip("-")  # Remove trailing hyphens

# Clean and split the 'STARS' column into 'DIRECTOR' and 'OUR_STARS'
df['STARS'] = df["STARS"].str.strip()  # Remove surrounding white spaces
df[['DIRECTOR', 'OUR_STARS']] = df['STARS'].str.split("|", n=2, expand=True)

# Extract and clean the 'DIRECTOR' column
df['DIRECTOR'] = df['DIRECTOR'].str.extract(r'Director:(.*)').str.strip()
df['DIRECTOR'] = df['DIRECTOR'].fillna('Unknown')  # Replace missing values with 'Unknown'

# Extract and clean the 'STARS' column
df["STARS"] = df["STARS"].str.extract(r'Star(.*)')
df["STARS"] = df["STARS"].str.lstrip("s:")  # Remove prefix 's:' if present
df["STARS"] = df["STARS"].fillna('Unknown')  # Replace missing values with 'Unknown'

# Clean the 'RATING' column
df["RATING"] = df["RATING"].apply(lambda x: str(x))
df["RATING"] = df["RATING"].str.replace("nan", "Unknown")

# Clean the 'VOTES' column
df["VOTES"] = df["VOTES"].apply(lambda x: str(x))
df["VOTES"] = df["VOTES"].str.replace("nan", "Unknown")

# Clean the 'RunTime' column
df["RunTime"] = df["RunTime"].apply(lambda x: str(x))
df["RunTime"] = df["RunTime"].str.replace("nan", "Unknown")

# Clean the 'Gross' column
df["Gross"] = df["Gross"].str.strip("$ M")  # Remove currency symbols
df["Gross"] = df["Gross"].apply(lambda x: str(x))
df["Gross"] = df["Gross"].str.replace("nan", "Unknown")

# Drop unnecessary columns
df = df.drop(columns="OUR_STARS")

# Reorder columns
df = df[["MOVIES", "YEAR", "GENRE", "RATING", "ONE-LINE", "DIRECTOR", "STARS", "VOTES", "RunTime", "Gross"]]

# Rename columns to uppercase
df = df.rename(columns=str.upper)

# Save the cleaned data to a new Excel file
df.to_excel("cleaned_movies.xlsx", index=False)

# Print the cleaned DataFrame
print(df)
