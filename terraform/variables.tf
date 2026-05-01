variable "subscription_id" {
  description = "Azure Subscription ID"
  type        = string
  default     = "156f9b3f-4714-4100-ad83-c22de61ace27"
}

variable "resource_group_name" {
  description = "Resource Group Name"
  type        = string
  default     = "ecommerce-rg"
}

variable "location" {
  description = "Azure Region"
  type        = string
  default     = "eastus"
}
