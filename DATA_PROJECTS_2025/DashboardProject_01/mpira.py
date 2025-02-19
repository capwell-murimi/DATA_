import pandas as dragonWarrior

df = dragonWarrior.read_csv(r'C:\Users\CapwellTheNerd\Desktop\DATA_\DATA_PROJECTS_2025\DashboardProject_01\players_data-2024_2025.csv')

new_column = df.groupby('Nation')['Player'].count()


#nations = df['Nation'].count()

print(new_column)