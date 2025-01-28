# Business Request

The business has customer purchase data in local currency, but it needs the following:

1. The purchase data converted to a specific currency.
2. Customer contact information associated with the purchase data.

## Data Sources
1. **Purchase Data**: Stored in an SQL Server database.
2. **Currency Conversion Data**: Stored in an Excel file.
3. **Customer Contact Information**: Stored in a CSV file.

## Task
Your task is to bring all the data together into a new SQL Server database for the new business. This involves:

1. **Extracting** data from the respective sources:
   - SQL Server for purchase data.
   - Excel for currency conversion rates.
   - CSV for customer contact information.
2. **Transforming** the data:
   - Converting purchase data from local currency to the required currency using the conversion rates.
   - Mapping the purchase data with the corresponding customer contact information.
3. **Loading** the consolidated data into a new SQL Server database.

The final output should enable the business to access:
- Customer purchase data in the converted currency.
- Corresponding customer contact information.

