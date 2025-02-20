import pandas as dragonWarrior

df = dragonWarrior.read_csv(r'C:\Users\CapwellTheNerd\Desktop\DATA_\DATA_PROJECTS_2025\DashboardProject_01\players_data-2024_2025.csv')

new_column  = df.groupby('Comp')['Player'].count().reset_index()

new_column.columns = ['Nation','No of Players']


#nations = df['Nation'].count()
new_column.to_csv('players_per_competition.csv', index=False)



print(new_column)